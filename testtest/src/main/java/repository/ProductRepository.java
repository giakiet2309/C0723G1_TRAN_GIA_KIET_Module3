package repository;

import model.ProductDTO;
import util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL_PRODUCT = "select * from hang_hoa hh join loai_hang_hoa lhh on lhh.id_loai_hang_hoa= hh.id_loai_hang_hoa;";

    @Override
    public List<ProductDTO> displayAllProduct() {
        Connection connection = BaseRepository.getConnectDB();
        List<ProductDTO> productDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_hang_hoa");
                String productCode = resultSet.getString("ma_hang_hoa");
                String name = resultSet.getString("ten_hang_hoa");
                String unit = resultSet.getString("don_vi_tinh");
                int price = resultSet.getInt("gia");
                String productType = resultSet.getString("ten_loai_hang_hoa");
                String harvestDate = resultSet.getString("ngay_thu_hoach");
                productDTOList.add(new ProductDTO(id,productCode,name,unit,price,productType,harvestDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productDTOList;
    }
}
