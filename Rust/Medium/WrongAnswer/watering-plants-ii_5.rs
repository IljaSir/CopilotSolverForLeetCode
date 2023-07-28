impl Solution {
    pub fn minimum_refill(plants: Vec<i32>, capacity_a: i32, capacity_b: i32) -> i32 {
        
        let mut i = 0;
        let mut j = plants.len() - 1;
        let mut count = 0;
        let mut a = capacity_a;
        let mut b = capacity_b;
        while i <= j {
            if i == j {
                if a + b < plants[i] {
                    count += 2;
                } else if a + b >= plants[i] && a < plants[i] && b < plants[i] {
                    count += 1;
                }
                break;
            }
            if a >= plants[i] {
                a -= plants[i];
                i += 1;
            } else {
                a = capacity_a - plants[i];
                i += 1;
                count += 1;
            }
            if b >= plants[j] {
                b -= plants[j];
                j -= 1;
            } else {
                b = capacity_b - plants[j];
                j -= 1;
                count += 1;
            }
        }
        count
    }
}