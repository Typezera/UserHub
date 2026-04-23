package com.loginComJwt.loginJWT.repository.friend;

import com.loginComJwt.loginJWT.model.friend.FriendShipModel;
import com.loginComJwt.loginJWT.model.friend.FriendshipStatus;
import com.loginComJwt.loginJWT.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<FriendShipModel, Long > {
    boolean existsBySenderAndReceiver(UserModel sender, UserModel receiver);
    List<FriendShipModel> findByReceiverAndStatus(UserModel receiver, FriendshipStatus status);
}
