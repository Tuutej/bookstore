package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepo;

    @Test
    public void findByNameRetrieveCategory() {
        List<Category> categories = categoryRepo.findByName("Fantasy");

        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Fantasy");
    }

    @Test
    public void createNewCategory() {
    	Category category = new Category("Noir");
		categoryRepo.save(category);
        assertThat(category.getCategoryid()).isNotNull();
    }


}
