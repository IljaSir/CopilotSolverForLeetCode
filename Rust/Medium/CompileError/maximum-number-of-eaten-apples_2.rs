impl Solution {
    pub fn eaten_apples(apples: Vec<i32>, days: Vec<i32>) -> i32 {
        
        let mut heap = std::collections::BinaryHeap::new();
        let mut sum = 0;
        for i in 0..apples.len() {
            heap.push((-(i as i32 + days[i]), apples[i]));
            while !heap.is_empty() {
                let (day, apple) = heap.peek().unwrap();
                if -day <= i as i32 || apple == &0 {
                    heap.pop();
                } else {
                    break;
                }
            }
            if !heap.is_empty() {
                let (_, apple) = heap.peek_mut().unwrap();
                *apple -= 1;
                sum += 1;
            }
        }
        let mut i = apples.len() as i32;
        while !heap.is_empty() {
            let (day, apple) = heap.peek().unwrap();
            if -day <= i || apple == &0 {
                heap.pop();
            } else {
                break;
            }
        }
        while !heap.is_empty() {
            let (day, apple) = heap.pop().unwrap();
            let eat = (-day - i).min(*apple);
            sum += eat;
            i += eat;
        }
        sum
    }
}