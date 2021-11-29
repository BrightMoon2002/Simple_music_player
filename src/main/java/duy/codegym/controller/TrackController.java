package duy.codegym.controller;

import duy.codegym.model.Track;
import duy.codegym.model.TrackForm;
import duy.codegym.service.IService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/track")
@PropertySource("classpath:upload_file.properties")
public class TrackController {
    @Autowired
    private IService trackService;
    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    public String showList(Model model) {

        model.addAttribute("trackList", trackService.findAll());
        return "/home";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView model = new ModelAndView("/create", "trackForm", new TrackForm());
        return model;
    }

    @PostMapping("/save")
    public ModelAndView createNewTrack(@ModelAttribute TrackForm trackForm) {
        MultipartFile multipartFile = trackForm.getTrackLink();
        String fileName = multipartFile.getOriginalFilename();
        try {
            //copy tu duong dan cu tracklink sang duong dan new file moi
            FileCopyUtils.copy(trackForm.getTrackLink().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Track track = new Track(trackForm.getName(), trackForm.getArtist(), trackForm.getType(), fileName);
        trackService.save(track);
        ModelAndView model = new ModelAndView("/create");
        model.addObject("trackForm", trackForm);
        model.addObject("message", "Create new track successful");
        return model;
    }

    @GetMapping ("/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Track> track = trackService.findById(id);
        ModelAndView model = new ModelAndView("/delete", "track", track.get());
        return model;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id) throws IOException {
        Optional<Track> track = trackService.findById(id);
        // tạo ra file moi co duong dan den file da luu trong serve
        File file = new File(fileUpload + track.get().getTrackLink());
        // tha file vao luong
        FileInputStream input = new FileInputStream(file);
        // tạo multipartfile mới (name,c ontenttype chi là chú thích nhưng bắt buộc phải có)
        MultipartFile multipartFile = new MockMultipartFile("abc",
                file.getName(), "mp3,mp4,.../audio", IOUtils.toByteArray(input));
        TrackForm trackForm = new TrackForm(track.get().getId(), track.get().getName(), track.get().getArtist(), track.get().getType(), multipartFile);
        ModelAndView model = new ModelAndView("/edit");
        model.addObject("track", trackForm);
        model.addObject("message", "Edit successful");
        return model;
    }

    @PostMapping("/delete")
    public ModelAndView removeTrack(@ModelAttribute Track track) {
        trackService.remove(track.getId());
        ModelAndView model = new ModelAndView("redirect:/track");
        return model;
    }

    @PostMapping("/edit")
    public ModelAndView editTrack(@ModelAttribute TrackForm trackForm) {
        MultipartFile multipartFile = trackForm.getTrackLink();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(trackForm.getTrackLink().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Track track = new Track(trackForm.getId(), trackForm.getName(), trackForm.getArtist(), trackForm.getType(), fileName);
        trackService.save(track);
        ModelAndView model = new ModelAndView("/edit");
        model.addObject("trackForm", trackForm);
        model.addObject("message", "edit new track successful");
        return model;
    }
}
