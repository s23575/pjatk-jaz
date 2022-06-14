package pl.edu.pjatk.jaz.nbp.rates.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.jaz.nbp.rates.models.Query;

public interface RateRepository extends JpaRepository<Query, Long> {

    Query save(Query queryToSave);
}
