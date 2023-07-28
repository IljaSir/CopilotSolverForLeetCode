impl Solution {
    pub fn max_profit(inventory: Vec<i32>, orders: i32) -> i32 {
        
        let mut inventory = inventory;
        inventory.sort();
        let mut i = inventory.len() - 1;
        let mut ans = 0;
        let mut orders = orders;
        while orders > 0 {
            let mut j = i;
            while j > 0 && inventory[j] == inventory[j - 1] {
                j -= 1;
            }
            let d = (i - j + 1) as i32;
            let k = inventory[i] - inventory[j];
            if k * d <= orders {
                ans += (inventory[i] + inventory[j] + 1) * k * d / 2;
                orders -= k * d;
            } else {
                let p = orders / d;
                let q = orders % d;
                ans += (inventory[i] + inventory[i] - p + 1) * p * d / 2;
                ans += (inventory[i] - p) * q;
                orders = 0;
            }
            i = j - 1;
        }
        (ans % 1000000007) as i32
    }
}