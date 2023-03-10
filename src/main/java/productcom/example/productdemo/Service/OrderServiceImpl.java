package productcom.example.productdemo.Service;

import org.springframework.stereotype.Service;
import productcom.example.productdemo.Entity.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{


    @Override
    public String updateReturn(Order order) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date createDate=order.getCreate_date();

        return null;
    }
}
