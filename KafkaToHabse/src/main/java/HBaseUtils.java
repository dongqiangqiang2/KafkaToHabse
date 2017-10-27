import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Random;
public class HBaseUtils {
    public  void put(String string) throws IOException {
        //设置HBase据库的连接配置参数
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum",  "CM-EL67-0001:2181,Tools-EL67-0001:2181");  //  Zookeeper的地址
        //conf.set("hbase.zookeeper.property.clientPort", "2181");
        Random random = new Random();
        long a = random.nextInt(1000000000);
        String tableName = "emp";
        String rowkey = "rowkey"+a ;
        String columnFamily = "userinfo";
        String column = "empname";

        HTable table=new HTable(conf, tableName);
        Put put=new Put(Bytes.toBytes(rowkey));
        put.add(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(string));
        table.put(put);//放入表
        System.out.println("aaaaaaaaaaaaa");
        table.close();//释放资源
    }
}
