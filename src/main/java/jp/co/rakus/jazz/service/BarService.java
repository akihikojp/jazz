package jp.co.rakus.jazz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.jazz.domain.Bar;
import jp.co.rakus.jazz.repository.BarRepository;

@Transactional
@Service
public class BarService {

	@Autowired
	private BarRepository barRepository;

	
	/**全喫茶店検索*/
	public List<Bar> findAllBars() {
		return barRepository.findAllBars();
	}
	
	/** @return 都道府県別 喫茶店情報 */
	public List<Bar> findByPrefectureId(Integer prefectureId) {
		return barRepository.findByPrefectureId(prefectureId);
	}
	
	/** @return 都道府県ver.(ページング番号に準じた10件数の喫茶店情報)*/
	public List<Bar> findByPrefectureIdOFFSET(Integer prefectureId, Integer pageNum){
		return barRepository.findByPrefectureIdOFFSET(prefectureId, pageNum);
	}
	

	/** @return 地域別 喫茶店情報 */
	public List<Bar> findByRegionId(Integer regionId) {
		return barRepository.findByRegionId(regionId);
	}
	
	public List<Bar> findByRegionIdOFFSET(Integer regionId, Integer pageNum){
		return barRepository.findByRegionIdOFFSET(regionId, pageNum);
	}
	
	/**緯度・経度情報の更新処理 @param address,latitude,longitude*/
	public void save(String address, double latitude, double longitude) {
		barRepository.save(address, latitude, longitude);
	}
	
	
}

