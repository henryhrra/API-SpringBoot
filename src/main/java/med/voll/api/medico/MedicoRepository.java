
package med.voll.api.medico;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//Se extiende de la clase JPARepository para poder hacer las peticiones de manera automatica
public interface MedicoRepository extends JpaRepository<Medico,Long> {

   // Page<Medico> findByActivoTrue(Pageable paginacion);*
   Page<Medico> findByActivoTrue(Pageable paginacion);
}
