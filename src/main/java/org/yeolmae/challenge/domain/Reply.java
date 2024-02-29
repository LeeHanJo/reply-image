package org.yeolmae.challenge.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.yeolmae.challenge.domain.Challenge;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "imageSet")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Challenge challenge;

    @Column(nullable = false)
    private String replyText;

    @Column(nullable = false)
    private String replyer;

    @OneToMany(mappedBy = "reply",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @Builder.Default
    @BatchSize(size = 20)
    private Set<ReplyImage> imageSet = new HashSet<>();

    public void addImage(String uuid, String fileName){

        ReplyImage boardImage = ReplyImage.builder()
                .uuid(uuid)
                .fileName(fileName)
                .reply(this)
                .ord(imageSet.size())
                .build();
        imageSet.add(boardImage);
    }

}