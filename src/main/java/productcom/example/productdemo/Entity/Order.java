package productcom.example.productdemo.Entity;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "ord")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int product_id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date return_date;
    @PrePersist
    private void oncreate() throws ParseException{
        create_date=new Date();

        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        calendar.add(Calendar.DATE,7);
        String sdate=sdf.format(calendar.getTime());
        return_date=sdf.parse(sdate);
    }

//    private void onreturnDate(Calendar calendar) throws ParseException {
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//     calendar=Calendar.getInstance();
//    calendar.setTime(new Date());
//    calendar.add(Calendar.DATE,7);
//    String sdate=sdf.format(calendar.getTime());
//
//
//       return_date=sdf.parse(sdate);
//
//    }

    public Order() {
    }

    public Order(int id, int product_id, Date create_date, Date return_date) {
        this.id = id;
        this.product_id = product_id;
        this.create_date = create_date;
        this.return_date = return_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
}
