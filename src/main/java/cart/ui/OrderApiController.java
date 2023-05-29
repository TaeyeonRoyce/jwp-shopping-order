package cart.ui;

import cart.application.OrderService;
import cart.domain.Member;
import cart.dto.OrderPreviewResponse;
import cart.dto.OrderResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderApiController {

    private final OrderService orderService;

    public OrderApiController(final OrderService orderService) {
        this.orderService = orderService;
    }

//    @PostMapping
//    public ResponseEntity<Void> addOrder(Member member, @RequestBody OrderPostRequest request) {
//
//        return ResponseEntity.created();
//    }

    @GetMapping()
    public ResponseEntity<List<OrderPreviewResponse>> findAllOrdersByMember(final Member member) {
        final List<OrderPreviewResponse> allOrdersByMember = orderService.findAllOrdersByMember(member);

        return ResponseEntity.ok(allOrdersByMember);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findOrderById(final Member member, @PathVariable final Long id) {
        final OrderResponse orderResponse = orderService.findOrderById(member, id);

        return ResponseEntity.ok(orderResponse);
    }
}
