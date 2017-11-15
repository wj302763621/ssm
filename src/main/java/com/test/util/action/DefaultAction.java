package com.test.util.action;

import com.test.util.ObjectToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by wangjian on 2017/11/6.
 */
public abstract class DefaultAction {
    @Resource
    private MessageSource messageSource;

    private Integer currentPage = 1;//
    private Integer lineSize = 2;//表示每页显示两条记录数

    public void print(HttpServletResponse response,Object msg){
        try {
            response.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handSplit(HttpServletRequest request,HttpServletResponse response){
        try {
            this.currentPage = Integer.parseInt(request.getParameter("cp"));
        }catch (Exception e){}
        try {
            this.lineSize = Integer.parseInt(request.getParameter("ls"));
        }catch (Exception e){}
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getLineSize() {
        return lineSize;
    }

    /**
     * 可以根据Key取得资源的内容
     * @param key 表示要读取key
     * @param param 表示设置的参数
     * @return
     */
    public String getResource(String key,String ...param){
        return this.messageSource.getMessage(key,param, Locale.getDefault());
    }

    /**
     * 设置提示信息与跳转路径，通过资源文件读取的
     * @param mav
     * @param msg
     * @param path
     */
    public void setMsgAndPath(ModelAndView mav,String msg,String path){
        if (mav != null){
            if (this.getText() != null){
                String [] result = this.getText().split("\\|");
                mav.addObject("msg",this.messageSource.getMessage(msg,result,Locale.getDefault()));
            }else{
                mav.addObject("msg",this.messageSource.getMessage(msg,null,Locale.getDefault()));
            }
            mav.addObject("path",this.messageSource.getMessage(path,null,Locale.getDefault()));

        }
    }

    public void printObjectToJson(HttpServletResponse response,Object vo){
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().print(ObjectToJson.convertorObjectToJson(vo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将list集合的数据装花城json
     * @param response
     * @param name
     * @param all
     */
    public void printObjectToList(HttpServletResponse response, String name, List<?>all){
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().print(ObjectToJson.convertorListToJson(name, all));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printObjectToListSplit(HttpServletResponse response, String name, List<?>all,Integer allRecorders){
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().print(ObjectToJson.convertorListSplitToJson(name, all, allRecorders));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract String getText();
}
