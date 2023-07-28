impl Solution {
    pub fn stone_game_vi(alice_values: Vec<i32>, bob_values: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut alice = 0;
        let mut bob = 0;
        let mut a = Vec::new();
        let mut b = Vec::new();
        for i in 0..alice_values.len() {
            a.push((alice_values[i], bob_values[i]));
            b.push((alice_values[i], bob_values[i]));
            sum += alice_values[i] + bob_values[i];
        }
        a.sort_by(|a, b| {
            let x = b.0 - b.1;
            let y = a.0 - a.1;
            if x == y {
                return b.0.cmp(&a.0);
            }
            x.cmp(&y)
        });
        b.sort_by(|a, b| {
            let x = b.1 - b.0;
            let y = a.1 - a.0;
            if x == y {
                return b.1.cmp(&a.1);
            }
            x.cmp(&y)
        });
        let mut i = 0;
        while i < a.len() {
            alice += a[i].0;
            i += 1;
            if i == a.len() {
                break;
            }
            bob += b[i].1;
            i += 1;
        }
        if alice > bob {
            return 1;
        } else if alice < bob {
            return -1;
        } else {
            return 0;
        }
    }
}