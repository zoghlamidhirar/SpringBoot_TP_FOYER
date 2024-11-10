package tn.esprit.tpfoyer.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.entity.Bloc;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
    BlocRepository BlocRepository;

    @Scheduled(fixedDelay = 60000)
    @Transactional
    public List<Bloc> retrieveAllBloc() {

        List<Bloc> blocs = BlocRepository.findAll();
        for (Bloc c: blocs) {
            log.info("Bloc :" + c);
        }
        return blocs;
    }
    public Bloc retrieveBloc(Long BlocId) {
        return BlocRepository.findById(BlocId).get();

    }
    public Bloc addBloc(Bloc b) {
        return BlocRepository.save(b);

    }

    public void removeBloc(Long BlocId) {
        BlocRepository.deleteById(BlocId);

    }

    public Bloc modifyBloc(Bloc Bloc) {
        return BlocRepository.save(Bloc);
    }

}
