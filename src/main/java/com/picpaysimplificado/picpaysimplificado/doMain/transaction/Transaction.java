package com.picpaysimplificado.picpaysimplificado.doMain.transaction;


import com.picpaysimplificado.picpaysimplificado.doMain.user.User;
import jakarta.persistence.*;
import lombok.*;

import javax.sound.midi.Receiver;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User receiver;

    private LocalDateTime localDateTime;


}
