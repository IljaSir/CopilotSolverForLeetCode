impl Solution {
    pub fn stone_game_vi(alice_values: Vec<i32>, bob_values: Vec<i32>) -> i32 {
        
        let n = alice_values.len();
        let mut sum = 0;
        let mut heap = std::collections::BinaryHeap::new();
        for i in 0..n {
            let alice = alice_values[i];
            let bob = bob_values[i];
            sum += alice;
            heap.push((alice + bob, alice, bob));
        }
        let mut alice_sum = 0;
        let mut bob_sum = 0;
        let mut alice = true;
        while let Some((_, alice_value, bob_value)) = heap.pop() {
            if alice {
                alice_sum += alice_value;
            } else {
                bob_sum += bob_value;
            }
            alice = !alice;
        }
        if alice_sum > bob_sum {
            1
        } else if alice_sum < bob_sum {
            -1
        } else {
            0
        }
    }
}