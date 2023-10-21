package nemo;

public class Nemo {
	
	public int positionX;
	public int positionY;
	public Direction direction;
	public int depth;

	public Nemo() {
		this.setPositionX(0);
		this.setPositionY(0);
		this.setDirection(new DirectionNorth());
		this.setDepth(0);
	}

	
	
	
	public void forward() {
		// TODO Auto-generated method stub
		
	}

	public void down() {
		// TODO Auto-generated method stub
		
	}

	public void up() {
		
	}

	public void turnLeft() {
		// TODO Auto-generated method stub
		
	}

	public void turnRight() {
		// TODO Auto-generated method stub
		
	}

	public void releaseCapsule() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	public Object getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public Object getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Object getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
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

