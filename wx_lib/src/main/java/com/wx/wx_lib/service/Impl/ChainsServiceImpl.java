package com.wx.wx_lib.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.wx_lib.dao.ChainsDao;
import com.wx.wx_lib.dao.CyDao;
import com.wx.wx_lib.model.Chains;
import com.wx.wx_lib.model.Cy;
import com.wx.wx_lib.service.ChainsService;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ChainsServiceImpl extends ServiceImpl<ChainsDao, Chains> implements ChainsService {

    @Autowired
    private CyDao cyDao;



    @Override
    public Boolean add(String values) throws BadHanyuPinyinOutputFormatCombination {
        boolean flag = false;
        Map<String,Object> map = new Hashtable<>();
        map.put("name",values);
        List<Cy> result = cyDao.selectByMap(map);
//        if (result.size() == 0){
//            log.info("此成语不存在="+values,values);
//            return false;
//        }
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);//大写
        //format.setCaseType(HanyuPinyinCaseType.LOWERCASE);//小写
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//不标声调
        //format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);//标符号声调放韵母上[LǙ]
        //format.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);//标数字声调放最右边[LÜ3]
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);// u:的声母
//        format.setVCharType(HanyuPinyinVCharType.WITH_V);// V:的声母
//        format.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);// u:的声母
//        Chains chains = baseMapper.selectOne(new QueryWrapper<Chains>().orderByDesc("id").last("limit 1"));
//        char end = chains.getName().charAt(chains.getName().length()-1);
        char end = Character.valueOf(this.getEnd());    //获取最后一个字
        char valueEnd = values.charAt(0); //获取第一个字
        String cy = Arrays.toString(PinyinHelper.toHanyuPinyinStringArray(end,format));
        String value = Arrays.toString(PinyinHelper.toHanyuPinyinStringArray(valueEnd,format));
        if (value.equals(cy)){
            Chains chains1 = new Chains();
//            chains1.setContent(result.get(0).getContent());
            chains1.setName(values);
            baseMapper.insert(chains1);
            return true;
        }
        return null;
    }

    @Override
    public char getEnd() {
        Chains chains = baseMapper.selectOne(new QueryWrapper<Chains>().orderByDesc("id").last("limit 1"));
        char end = chains.getName().charAt(chains.getName().length()-1);
        return end;
    }

    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
//        this.add("阿猫阿狗");
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);//大写
        //format.setCaseType(HanyuPinyinCaseType.LOWERCASE);//小写
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//不标声调
        //format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);//标符号声调放韵母上[LǙ]
        //format.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);//标数字声调放最右边[LÜ3]
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);// u:的声母
//        format.setVCharType(HanyuPinyinVCharType.WITH_V);// V:的声母
//        format.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);// u:的声母
        String values = "你好帅";
        char end = values.charAt(values.length()-1); //获取最后一个字
        String value = Arrays.toString(PinyinHelper.toHanyuPinyinStringArray(end,format));
        System.out.println(value);
        System.out.println(Arrays.toString(PinyinHelper.toHanyuPinyinStringArray(end,format)));
    }

}
