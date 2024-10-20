package tn.esprit.tpfoyer.control;

import tn.esprit.tpfoyer.service.BlocServiceImpl;
import tn.esprit.tpfoyer.service.IBlocService;
import tn.esprit.tpfoyer.service.ChambreServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Bloc;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {

    IBlocService BlocService;

    @GetMapping("/retrive-all-Blocs")
    public List<Bloc> getBloc(){
        List<Bloc> listBloc=BlocService.retrieveAllBloc();
        return listBloc;
    }

    @GetMapping("/retrive-Bloc/{Bloc-id}")
    public Bloc retriveBloc(@PathVariable("Bloc-id") Long BlocId ){
        Bloc Bloc= BlocService.retrieveBloc(BlocId);
        return Bloc;

    }

    @PostMapping("/add-Bloc")
    public Bloc addBloc(@RequestBody Bloc b){
        Bloc Bloc=BlocService.addBloc(b);
        return Bloc;
    }

    @DeleteMapping("/remove-Bloc/{Bloc-id}")
    public void removeBloc(@PathVariable("Bloc-id") Long BlocId){
        BlocService.removeBloc(BlocId);
    }

    @PutMapping("/modify-bloc")
    public Bloc modifyChamber(@RequestBody Bloc b){
        Bloc Bloc=BlocService.modifyBloc(b);
        return Bloc;
    }


}
