impl Solution {
    pub fn num_equiv_domino_pairs(dominoes: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        let mut a = [0; 100];
        for dominoe in dominoes {
            let x = std::cmp::min(dominoe[0], dominoe[1]);
            let y = std::cmp::max(dominoe[0], dominoe[1]);
            count += a[x * 10 + y];
            a[x * 10 + y] += 1;
        }
        count
    }
}