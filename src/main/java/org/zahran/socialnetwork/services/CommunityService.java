package org.zahran.socialnetwork.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zahran.socialnetwork.dto.ImageDto;
import org.zahran.socialnetwork.dto.MessageDto;

import java.util.Arrays;
import java.util.List;

@Service
public class CommunityService {

    public List<MessageDto> getCommunityMessages(int page){

        return Arrays.asList(
                new MessageDto(1L,"first message"),
                new MessageDto(2L,"second message")
        );
    }

    public List<ImageDto> getCommunityImages(int page){

        return  Arrays.asList(
                new ImageDto(1L,"first title",null),
                new ImageDto(2L,"second title",null)
        );
    }

    public MessageDto postMessage(MessageDto messageDto){
        return  new MessageDto(3L,"new message");
    }

    public ImageDto postImage(MultipartFile file,String title){
        return  new ImageDto(3L,"new title",null);
    }
}
