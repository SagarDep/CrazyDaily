package com.crazysunj.crazydaily.presenter.contract;

import com.crazysunj.crazydaily.base.IPresenter;
import com.crazysunj.crazydaily.base.IView;
import com.crazysunj.domain.entity.photo.BucketEntity;
import com.crazysunj.domain.entity.photo.MediaEntity;

import java.util.Date;
import java.util.List;

/**
 * author: sunjian
 * created on: 2018/9/17 下午2:29
 * description:
 */
public interface PhotoPickerContract {
    interface View extends IView {
        void showMediaList(Date toDate, int page, int offset, List<MediaEntity> mediaList);

        void showBucketList(List<BucketEntity> bucketList);
    }

    interface Presenter extends IPresenter<View> {
        void getMediaList(Date toDate, int page, int offset, int count, String bucketId);

        void getBucketList();
    }
}
