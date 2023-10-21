package nemo;

public class NemoSurface extends NemoDepths{

	public NemoSurface() {
		this.depthValue = 0;
	}

	public boolean release() {
		return true;
	}

	@Override
	public void moveUp(Nemo nemo) {
		nemo.depth = 0;
		
	}
	
}
