package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;
	
	public TV() {}
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	
	public int getChannel() {
		return channel;
	}

	public void channel(int channel) {
		if (channel <= 0) this.channel = 255;
		else if (channel >= 256) this.channel = 0;
		else this.channel = channel;
	}
	
	public void channel(boolean up) {
		if (up) {
			int curr = this.getChannel();
			if (curr == 255) channel(1);
			else channel(curr + 1);
		} else {
			int curr = this.getChannel();
			if (curr == 1) channel(255);
			else channel(curr - 1);
		}
	}

	public int getVolume() {
		return volume;
	}

	public void volume(int volume) {
		this.volume = volume;
	}
	
	public void volume(boolean up) {
		if (up) {
			int curr = this.getVolume();
			if (curr == 100) volume(0);
			else volume(curr + 1);
		} else {
			int curr = this.getVolume();
			if (curr == 0) channel(100);
			else volume(curr - 1);
		}
	}

	public boolean isPower() {
		return power;
	}

	public void power(boolean power) {
		this.power = power;
	}

	public void status() {
		System.out.println("TV[channel=" + this.getChannel() + ", volume=" + this.getVolume() + ", power="
				+ (power ? "on" : "off") + "]");
	}
}
