package nemo;

public class NemoDepthHigherThanOne extends NemoDepths{

	public NemoDepthHigherThanOne() {
		this.depthValue = 1;
	}

	public boolean release() {
		throw new Error("Nemo explotó");
	}

	@Override
	public void moveUp(Nemo nemo) {
		nemo.depth -= 1;
	}
	

}
