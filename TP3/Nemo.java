package Nemo.src;

import java.util.ArrayList;
import java.util.List;

public class Nemo {
	
	private int positionX;
	private int positionY;
	private Direction direction;
	private int depth;
	private NemoDepths nemoDepth;
	List<Commands> commands = new ArrayList<Commands>();

	public Nemo() {
		this.setPositionX(0);
		this.setPositionY(0);
		this.setDirection(new DirectionNorth());
		this.setDepth(0);
		this.setNemoDepth(new NemoSurface());
	}
	
	public Commands findCommand (char instruction) {
		commands.add(new CommandDown());
		commands.add(new CommandUp());
		commands.add(new CommandForward());
		commands.add(new CommandTurnLeft());
		commands.add(new CommandTurnRight());
		commands.add(new CommandReleaseCapsule());
		
		return commands.stream()
	            .filter(command -> command.getKey() == instruction)
	            .findFirst()
	            .orElse(null);
	}
	
	public void move (char instruction) {
		this.findCommand(instruction).processCommand(this);
	}
	
	public void move (String instruction) {
		instruction.chars().forEach(c -> move((char) c));
	}
	
	public void forward() {
		this.direction.moveForward(this);
	}

	public void down() {
		this.depth += 1;
		if(this.depth == 1) {
			this.setNemoDepth(new NemoDepthOne());
		}else {
			this.setNemoDepth(new NemoDepthHigherThanOne());
		}
	}

	public void up() {
		if(this.depth > 0) {
			this.depth -= 1;
			if(this.depth == 0) {
				this.setNemoDepth(new NemoSurface());
			}else if(this.depth == 1) {
				this.setNemoDepth(new NemoDepthOne());
			}else {
				this.setNemoDepth(new NemoDepthHigherThanOne());
			}
		}
	}

	public void turnLeft() {
		this.setDirection(this.getDirection().left());
	}

	public void turnRight() {
		this.setDirection(this.getDirection().right());
	}

	public void releaseCapsule() {
		this.getNemoDepth().release();
	}

	
	
	
	
	public Integer getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public Integer getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Object object) {
		this.direction = (Direction)object;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public NemoDepths getNemoDepth() {
		return nemoDepth;
	}

	public void setNemoDepth(NemoDepths nemoDepth) {
		this.nemoDepth = nemoDepth;
	}
	
	
}	
	
	
	
	
	

	
//    private int depth;
//    private int orientation;
//    private int x;  
//    private int y;  
//    private boolean capsuleReleased;
//
//    public Nemo() {
//        depth = 0;
//        orientation = 0;
//        x = 0;
//        y = 0;
//        capsuleReleased = false;
//    }
//
//    public void processCommands(String commands) {
//        for (char command : commands.toCharArray()) {
//            processCommand(command);
//        }
//    }
//
//    public void processCommand(char command) {
//        if (command == 'd') {
//            depth++;
//        } else if (command == 'u') {
//            depth = Math.max(0, depth - 1);
//        } else if (command == 'l') {
//            orientation = (orientation + 270) % 360;
//        } else if (command == 'r') {
//            orientation = (orientation + 90) % 360;
//        } else if (command == 'f') {
//            int deltaX = (int) Math.cos(Math.toRadians(orientation));
//            int deltaY = (int) Math.sin(Math.toRadians(orientation));
//            x += deltaX;
//            y += deltaY;
//        } else if (command == 'm' && (depth == 0 || depth == 1)) {
//            capsuleReleased = true;
//        }
//    }
//
//    public int getDepth() {
//        return depth;
//    }
//
//    public int getOrientation() {
//        return orientation;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public boolean isCapsuleReleased() {
//        return capsuleReleased;
//    }

