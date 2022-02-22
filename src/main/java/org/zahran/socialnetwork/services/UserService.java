package org.zahran.socialnetwork.services;

import org.springframework.stereotype.Service;
import org.zahran.socialnetwork.dto.ImageDto;
import org.zahran.socialnetwork.dto.MessageDto;
import org.zahran.socialnetwork.dto.ProfileDto;
import org.zahran.socialnetwork.dto.UserSummaryDto;

import java.util.Arrays;
import java.util.List;
@Service
public class UserService {

    public ProfileDto getProfile(Long userId) {
        return new ProfileDto(new UserSummaryDto(1L, "Sergio", "Lema"),
                Arrays.asList(new UserSummaryDto(2L, "John", "Doe")),
                Arrays.asList(new MessageDto(1L, "My message")),
                Arrays.asList(new ImageDto(1L, "Title", null)));
    }

    public void addFriend(Long friendId) {
        return;
    }

    public List<UserSummaryDto> searchUsers(String term) {
        return Arrays.asList(new UserSummaryDto(1L, "Sergio", "Lema"),
                new UserSummaryDto(2L, "John", "Doe"));
    }
}
