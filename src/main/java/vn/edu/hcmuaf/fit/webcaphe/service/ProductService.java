package vn.edu.hcmuaf.fit.webcaphe.service;

import vn.edu.hcmuaf.fit.webcaphe.model.Product;
import vn.edu.hcmuaf.fit.webcaphe.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Lấy danh sách sản phẩm để hiển thị trên giao diện admin
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // [Bước 6] Nhận dữ liệu sản phẩm từ Controller
    public Product addProduct(Product product) {
        // Thiết lập thời gian tạo và cập nhật trước khi lưu
        product.setCreatedDate(LocalDateTime.now());
        product.setUpdatedDate(LocalDateTime.now());
        // [Bước 7] Gọi Repository để lưu sản phẩm vào cơ sở dữ liệu
        return productRepository.save(product);
    }
}