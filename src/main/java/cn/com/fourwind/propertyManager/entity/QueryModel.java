package cn.com.fourwind.propertyManager.entity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




/**
 * @项目名称: yusp-common
 * @类名称: QueryModel
 * @类描述: 查询对象
 * @功能描述: 
 * @创建人: liwei17@yusys.com.cn
 * @创建时间: 2018-01-17 10:31
 * @修改备注: 修改时间    修改人员    修改原因 <br/>
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public class QueryModel {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    private Map<String, Object> condition = new HashMap<String, Object>();

    /**
     * @属性名称: page
     * @属性描述: 第几页(分页参数)
     * @since 1.0.0
     */
    private int page;

    /**
     * @属性名称: size
     * @属性描述: 一页多少条数据(分页参数)
     * @since 1.0.0
     */
    private int size = 10;

    public Map<String, Object> getCondition() {
        return condition;
    }

    /**
     * @方法名称: setCondition
     * @方法描述: 设置查询条件.
     *            会将Json字符串转为Map
     * @参数与返回说明: 
     * @算法描述: 无
     */
    @SuppressWarnings("unchecked")
    public void setCondition(String jsonCondition) {
        ObjectMapper jsonObj = new ObjectMapper();
        try {
            this.condition = jsonObj.readValue(jsonCondition, Map.class);
        } catch (JsonParseException e) {
            log.error("将查询条件condition转换为map格式出错", e);
        } catch (JsonMappingException e) {
            log.error("将查询条件condition转换为map格式出错", e);
        } catch (IOException e) {
            log.error("将查询条件condition转换为map格式出错", e);
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
