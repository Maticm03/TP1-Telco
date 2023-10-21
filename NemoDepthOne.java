package nemo;

public class NemoDepthOne extends NemoDepths{

	public NemoDepthOne() {
		this.depthValue = 1;
	}

	public boolean release() {
		return true;
	}

	@Override
	public void moveUp(Nemo nemo) {
		nemo.depth -=1;
		
	}
	

}
