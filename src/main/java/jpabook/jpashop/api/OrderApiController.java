package jpabook.jpashop.api;


import jpabook.jpashop.domain.Order;
import jpabook.jpashop.dto.OrderDto;
import jpabook.jpashop.dto.ResponseDto;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


/**
 * xToOne (OneToOne, ManyToOne)
 * Order
 * Order -> Member
 * Order -> Item
 * Order -> Delivery
 */
@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderService orderService;

    @GetMapping("/api/v2/orders")
    public ResponseDto<List<OrderDto>> getOrdersV2(){
        List<Order> orders = orderService.findOrders(new OrderSearch());

        List<OrderDto> result = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());

        return new ResponseDto<>(result);
    }


}
