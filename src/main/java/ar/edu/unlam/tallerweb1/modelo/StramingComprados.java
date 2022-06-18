package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name="streamings_comprados")
public class StramingComprados {
	
	@Id @GeneratedValue
	@Column(name = "Id")
	private int id;
	
	@Column(name = "StreamingId")
	private int streamingId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStreamingId() {
		return streamingId;
	}

	public void setStreamingId(int streamingId) {
		this.streamingId = streamingId;
	}
	
}
