
package acme.features.manager.task;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ManagerTaskRepository extends AbstractRepository {

	@Query("select t from Task t where t.id =?1")
	Task findOneById(int id);

	@Query("select m from Manager m where m.id =?1")
	Manager findManagerById(int activeRoleId);

	@Query("select m.tasks from Manager m where m.id=?1")
	Collection<Task> findManyByManagerId(int managerId);

}
