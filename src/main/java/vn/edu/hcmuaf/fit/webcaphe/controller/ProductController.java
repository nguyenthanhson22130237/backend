package vn.edu.hcmuaf.fit.webcaphe.controller;

import vn.edu.hcmuaf.fit.webcaphe.model.Product;
import vn.edu.hcmuaf.fit.webcaphe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "https://resplendent-gumdrop-c65ac7.netlify.app")
public class ProductController {

    @Autowired
    private ProductService productService;

    // [Bước 5] Nhận request POST từ client chứa thông tin sản phẩm, ánh xạ JSON thành đối tượng Product
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        // [Bước 6] Gọi ProductService để xử lý logic nghiệp vụ thêm sản phẩm
        Product savedProduct = productService.addProduct(product);

        // [Bước 9] Trả về mã HTTP 200 kèm dữ liệu sản phẩm đã lưu
        return ResponseEntity.ok(savedProduct);
    }

    // Lấy danh sách sản phẩm để hiển thị trên giao diện admin
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        // Controller yêu cầu Service lấy danh sách sản phẩm từ cơ sở dữ liệu
        List<Product> products = productService.getAllProducts();
        // Trả về danh sách sản phẩm dưới dạng JSON cho frontend
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}