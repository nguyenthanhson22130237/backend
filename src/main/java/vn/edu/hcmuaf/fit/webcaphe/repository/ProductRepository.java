package vn.edu.hcmuaf.fit.webcaphe.repository;

import vn.edu.hcmuaf.fit.webcaphe.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // [Bước 8] Repository cung cấp phương thức save() để lưu sản phẩm vào cơ sở dữ liệu
    // Cũng cung cấp findAll() để lấy danh sách sản phẩm
}