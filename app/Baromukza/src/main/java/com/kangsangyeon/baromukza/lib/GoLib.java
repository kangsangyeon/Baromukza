package com.kangsangyeon.baromukza.lib;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


/**
 * 액티비티나 프래그먼트 실행 라이브러리
 */
public class GoLib {
    public static final String TAG = GoLib.class.getSimpleName();

    /**
     * 프래그먼트를 보여준다.
     * @param fragmentManager 프래그먼트 매니저
     * @param containerViewId 프래그먼트를 보여줄 컨테이너 뷰 아이디
     * @param fragment 프래그먼트
     */
    public static void goFragment(FragmentManager fragmentManager, int containerViewId,
                           Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(containerViewId, fragment)
                .commit();
    }

    /**
     * 뒤로가기를 할 수 있는 프래그먼트를 보여준다.
     * @param fragmentManager 프래그먼트 매니저
     * @param containerViewId 프래그먼트를 보여줄 컨테이너 뷰 아이디
     * @param fragment 프래그먼트
     */
    public static void goFragmentBack(FragmentManager fragmentManager, int containerViewId,
                               Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(containerViewId, fragment)
                .addToBackStack(null)
                .commit();
    }

    /**
     * 이전 프래그먼트를 보여준다.
     * @param fragmentManager 프래그먼트 매니저
     */
    public static void goBackFragment(FragmentManager fragmentManager) {
        fragmentManager.popBackStack();
    }

    /**
     * 프로파일 액티비티를 실행한다.
     * @param context 컨텍스트
     */
//    public static void goProfileActivity(Context context) {
//        Intent intent = new Intent(context, ProfileActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//    }

//    /**
//     * 맛집 정보 등록 액티비티를 실행한다.
//     * @param context 컨텍스트
//     */
//    public void goBestFoodRegisterActivity(Context context) {
//        Intent intent = new Intent(context, BestFoodRegisterActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//    }
//
//
//    /**
//     * 맛집 정보 액티비티를 실행한다.
//     * @param context 컨텍스트
//     * @param infoSeq 맛집 정보 일련번호
//     */
//    public void goBestFoodInfoActivity(Context context, int infoSeq) {
//        Intent intent = new Intent(context, BestFoodInfoActivity.class);
//        intent.putExtra(BestFoodInfoActivity.INFO_SEQ, infoSeq);
//        context.startActivity(intent);
//    }
}
