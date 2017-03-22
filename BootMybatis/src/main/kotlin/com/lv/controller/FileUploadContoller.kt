package com.lv.controller

import com.lv.dto.ResultDto
import com.lv.enums.ResultEnum
import com.lv.util.ResultUtil
import com.lv.util.logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.ModelAndView
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream

/**
 * Date: 2017-03-22
 * Time: 11:14
 * Description:
 */
@RestController
class FileUploadContoller {


    /**
     * 文件上传
     */

    @PostMapping("/upload")
    fun upload(@RequestParam("file") file: MultipartFile): ResultDto {
        if (file.isEmpty)
            return ResultUtil.error(ResultEnum.EMPTY)
        /*
               * 这段代码执行完毕之后，图片上传到了工程的跟路径；
               * 大家自己扩散下思维，如果我们想把图片上传到 d:/files大家是否能实现呢？
               * 等等;
               * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如：
               * 1、文件路径；
               * 2、文件名；
               * 3、文件格式;
               * 4、文件大小的限制;
               */
        saveFile(file)
        return ResultUtil.success()
    }

    private fun saveFile(file: MultipartFile) {
        val outputStream = BufferedOutputStream(FileOutputStream(File(file.originalFilename)))
        outputStream.write(file.bytes)
        outputStream.flush()
        outputStream.close()
    }

    @GetMapping("/fileUpload")
    fun file(): ModelAndView {
        return ModelAndView("/file")
    }

    @GetMapping("/mutifile")
    fun mutifile(): ModelAndView {
        return ModelAndView("/mutifile")
    }

    @PostMapping("/mutifileUpload")
    fun mutifileUpload(@RequestParam("file") files: List<MultipartFile>): ResultDto {
        logger.info("files size={}", files.size)
        files.filterNot { it.isEmpty }
                .forEach { saveFile(it) }
        return ResultUtil.success()
    }


}