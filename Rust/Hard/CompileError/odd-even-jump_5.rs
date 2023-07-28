impl Solution {
    pub fn odd_even_jumps(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut next_higher = vec![0; n];
        let mut next_lower = vec![0; n];
        let mut stack = vec![];
        for &a in arr.iter().rev() {
            while !stack.is_empty() && a > arr[*stack.last().unwrap()] {
                next_higher[*stack.last().unwrap()] = a;
                stack.pop();
            }
            stack.push(a);
        }
        stack.clear();
        for &a in arr.iter().rev() {
            while !stack.is_empty() && a < arr[*stack.last().unwrap()] {
                next_lower[*stack.last().unwrap()] = a;
                stack.pop();
            }
            stack.push(a);
        }
        let mut higher = vec![false; n];
        let mut lower = vec![false; n];
        higher[n - 1] = true;
        lower[n - 1] = true;
        for i in (0..n - 1).rev() {
            if next_higher[i] > 0 {
                higher[i] = lower[next_higher[i] as usize];
            }
            if next_lower[i] > 0 {
                lower[i] = higher[next_lower[i] as usize];
            }
        }
        higher.iter().filter(|v| **v).count() as i32
    }
}