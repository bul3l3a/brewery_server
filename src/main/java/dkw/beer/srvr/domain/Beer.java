package dkw.beer.srvr.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {
	@Id
	// Must have hibernate 5+  
	@GeneratedValue  
	// or use @GeneratedValue(generator = "uuid") with @GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type="uuid-char") @Column(length = 36)
	UUID id;
	@Version
	private Long version;
	@CreationTimestamp
	@Column(updatable = false)
	private Date createdDate;
	@UpdateTimestamp
	private Date lastModifiedDate;
	private String beerName;
	private String beerStyle;
	@Column(unique = true)
	private Long upc;
	private BigDecimal price;
	
	private Integer minOnHand;
	private Integer quantityToBrew;
}
