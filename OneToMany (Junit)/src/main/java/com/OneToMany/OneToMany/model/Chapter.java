package com.OneToMany.OneToMany.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chapter")
public class Chapter {
/*Table Chapter memiliki field:
1. id (Long)
2. name (String)
3. content (String)
4. book_id (Long)
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    //foreign key
    @ManyToOne(cascade =CascadeType.PERSIST, optional = true)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "is_deleted")
    private Boolean isDeleted;


}
