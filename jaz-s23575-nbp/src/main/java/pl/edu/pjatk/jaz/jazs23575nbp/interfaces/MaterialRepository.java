package pl.edu.pjatk.jaz.jazs23575nbp.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.jaz.jazs23575nbp.models.MaterialQuery;

public interface MaterialRepository extends JpaRepository<MaterialQuery, Long> {

    MaterialQuery save(MaterialQuery materialQueryToSave);
}
