package core.adapters;

import Google.GoogleManager;
import core.abstracts.GoogleService;

public class GoogleManagerAdapter implements GoogleService {

	@Override
	public void registerToSystem() {
		GoogleManager googleManager = new GoogleManager();
		googleManager.register();
		
	}
}
