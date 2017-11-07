package com.kangsangyeon.baromukza.lib;

/**
 * 위치 정보와 관련된 라이브러리
 */
public class GeoLib {
    public static final String TAG = GeoLib.class.getSimpleName();

//    /**
//     * 사용자의 현재 위도, 경도를 반환한다.
//     * 실제로는 최근 측정된 위치 정보이다.
//     * @param context 컨텍스트 객체
//     */
//    public static void setLastKnownLocation(Context context) {
//        LocationManager locationManager
//                = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
//        Location location = null;
//
//        int result = ContextCompat.checkSelfPermission(context,
//                Manifest.permission.ACCESS_FINE_LOCATION);
//        if (result == PackageManager.PERMISSION_GRANTED) {
//            location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
//        }
//
//        if (location != null) {
//            GeoItem.knownLatitude = location.getLatitude();
//            GeoItem.knownLongitude = location.getLongitude();
//        } else {
//            //서울 설정
//            GeoItem.knownLatitude = 37.566229;
//            GeoItem.knownLongitude = 126.977689;
//        }
//    }
//
//    /**
//     * 지정된 위도경도 객체에 해당하는 주소 문자열을 반환한다.
//     * @param context 컨텍스트 객체
//     * @param latLng 위도, 경도 객체
//     * @return Address 주소 객체
//     */
//    public static Address getAddressString(Context context, LatLng latLng) {
//        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
//
//        List<Address> list = null;
//
//        try {
//            list = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (list != null && list.size() > 0) {
//            return list.get(0);
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     * Address 객체로부터 주소 문자열을 추출하여 반환한다.
//     * @param address 주소 객체
//     * @return 주소 문자열
//     */
//    public static String getAddressString(Address address) {
//        String address2 = "";
//        if (address.getAddressLine(1) != null) {
//            address2 = " " + address.getAddressLine(1);
//        }
//        return address.getAddressLine(0) + address2;
//    }
//
//    /**
//     * 화면 중앙으로부터 화면 왼쪽까지의 거리를 반환한다.
//     * @param map 구글 지도 객체
//     * @return 거리(m)
//     */
//    public static int getDistanceMeterFromScreenCenter(GoogleMap map) {
//        VisibleRegion vr = map.getProjection().getVisibleRegion();
//        double left = vr.latLngBounds.southwest.longitude;
//
//        Location leftLocation = new Location("left");
//        leftLocation.setLatitude(vr.latLngBounds.getCenter().latitude);
//        leftLocation.setLongitude(left);
//
//        Location center=new Location("center");
//        center.setLatitude( vr.latLngBounds.getCenter().latitude);
//        center.setLongitude( vr.latLngBounds.getCenter().longitude);
//        return  (int) center.distanceTo(leftLocation);
//    }
}
