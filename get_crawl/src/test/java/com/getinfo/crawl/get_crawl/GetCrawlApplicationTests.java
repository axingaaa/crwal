package com.getinfo.crawl.get_crawl;

import com.getinfo.crawl.get_crawl.config.ShenjianConfig;
import io.shenjian.sdk.ShenjianClient;
import io.shenjian.sdk.ShenjianException;
import io.shenjian.sdk.model.Crawler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetCrawlApplicationTests {

    @Autowired
    RestTemplateBuilder templateBuilder;
    @Autowired
    ShenjianConfig shenjianConfig;


    //查询爬虫的结果集
    @Test
    public void contextLoads() throws NoSuchAlgorithmException {
        String userKey = shenjianConfig.getUserKey(); //用户名
        String userSecret = shenjianConfig.getUserSecret(); //秘钥
        long time = new Date().getTime()/1000; //秒级时间戳
//        System.out.println("userSecret = " + userSecret);
        //获取restTemplate
        RestTemplate restTemplate = templateBuilder.build();
        String plainText=userKey+time+userSecret; //签名
        String sign = ShenjianConfig.stringToMD5(plainText); //签名加密
//        System.out.println("s = " + s);
//取到数据源ID
        String sourceId=shenjianConfig.getSourceId().get(1);
        System.out.println("sourceId = " + sourceId);
//查询条件，默认查询所有
         String source= "source{}";
//    user_key=用户key&timestamp=秒级时间戳&sign=签名&source_id=数据源ID&query=查询请求
        System.out.println("url"+shenjianConfig.getUrl());
//拼接URL
        String url=shenjianConfig.getUrl()+"?user_key="+userKey+"&timestamp="+time+"&sign="+sign+"&source_id="+sourceId+"&query="+source;
        System.out.println("url = " + url);
//获取结果集


//        System.out.println("time = " + time);
    }

    //调用接口爬虫
    @Test
    public void startCrawl() {




}
    //停止接口爬虫
    @Test
    public void sudu() {
        String userKey = shenjianConfig.getUserKey(); //用户名
        String userSecret = shenjianConfig.getUserSecret(); //秘钥
        ShenjianClient client = new ShenjianClient(userKey, userSecret);

        try {
            String name = "***JavaSDKTest***";
            String info = "***AomzonTest***";
            String code = "/*\n" +
                    "\t神箭手云_爬虫开发\n" +
                    "    支持原生JavaScript\n" +
                    "    开发教程：http://docs.shenjian.io/develop/crawler/doc/concept/crawler.html\n" +
                    "*/\n" +
                    "var configs = {\n" +
                    "  enableJS : true,\n" +
                    "  domains: [\"amazon.com\"],\n" +
                    "  scanUrls: [\"https://www.amazon.com\"],\n" +
                    "  contentUrlRegexes: [\"https://www.amazon.com\"], //内容页url正则\n" +
                    "//   helperUrlRegexes: [/http:\\/\\/.*/], //列表页url正则 可留空\n" +
                    "  fields: [\n" +
                    "    {\n" +
                    "      // 抽取项\n" +
                    "      name: \"catergory\",\n" +
                    "      selector: \"//*[@id='searchDropdownBox']\", //默认使用XPath\n" +
                    "      required: true //是否不能为空\n" +
                    "    }\n" +
                    "  ]\n" +
                    "};\n" +
                    "var crawler = new Crawler(configs);\n" +
                    "\n" +
                    "configs.afterExtractField =  function (fieldName,data,page,site){\n" +
                    "  if(fieldName ==\"catergory\"){\n" +
                    "  return  extract(data, \"//option\");\n" +
                    "  }\n" +
                    "}\n" +
                    "\n" +
                    "  \n" +
                    "\n" +
                    "\n" +
                    "crawler.start();\n" +
                    "//  extract(crawler, \"//option\");\n";
            Crawler crawler = client.createCrawler(name, info, code);
            System.out.println("Crawler ID : " + crawler.getAppId());
            System.out.println("Crawler name : " + crawler.getName());
            System.out.println("Crawler status : " + crawler.getStatus());
            System.out.println("Create time : " + crawler.getCreateTime());
        } catch (ShenjianException e) {
            e.printStackTrace();
        }


    }
}
