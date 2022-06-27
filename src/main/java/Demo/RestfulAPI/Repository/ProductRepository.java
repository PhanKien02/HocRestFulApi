package Demo.RestfulAPI.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Demo.RestfulAPI.Model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

    @Query(value = "select * from Product as p where p.id = :id", nativeQuery = true)
    ProductModel findOneById(@Param("id") int id);

    @Query(value = "select * from Product as p where p.nameproduct = :nameproduct ", nativeQuery = true)
    List<ProductModel> findByNameProduct(@Param("nameproduct") String nameproduct);
}
