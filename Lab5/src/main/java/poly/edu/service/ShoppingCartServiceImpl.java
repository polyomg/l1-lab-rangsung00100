package poly.edu.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import poly.edu.entity.DB;
import poly.edu.entity.Item;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	private Map<Integer, Item> cart = new HashMap<>();

	@Override
	public Item add(Integer id) {
		Item item = DB.items.get(id);
		if (item == null) {
			return null; // Nếu sản phẩm không tồn tại trong DB, không thêm vào giỏ
		}
		Item cartItem = cart.get(id);
		if (cartItem == null) {
			cartItem = new Item(item.getId(), item.getName(), item.getPrice(), 1);
			cart.put(id, cartItem);
		} else {
			cartItem.setQty(cartItem.getQty() + 1);
		}
		return cartItem;
	}

	@Override
	public void remove(Integer id) {
		cart.remove(id);
	}

	@Override
	public Item update(Integer id, int qty) {
		Item item = cart.get(id);
		if (item != null && qty > 0) {
			item.setQty(qty);
		} else if (qty <= 0) {
			cart.remove(id);
		}
		return item;
	}

	@Override
	public void clear() {
		cart.clear();
	}

	@Override
	public Collection<Item> getItems() {
		return cart.values();
	}

	@Override
	public int getCount() {
		return cart.values().stream().mapToInt(Item::getQty).sum();
	}

	@Override
	public double getAmount() {
		return cart.values().stream().mapToDouble(item -> item.getPrice() * item.getQty()).sum();
	}
}
