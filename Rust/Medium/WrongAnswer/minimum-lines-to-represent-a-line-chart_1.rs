impl Solution {
    pub fn minimum_lines(stock_prices: Vec<Vec<i32>>) -> i32 {
        
        let mut stack: Vec<Vec<i32>> = vec![];
        for i in 0..stock_prices.len() {
            let mut p = stock_prices[i].clone();
            while stack.len() > 1 && (stack[stack.len() - 1][0] - stack[stack.len() - 2][0]) * (p[1] - stack[stack.len() - 1][1]) >= (stack[stack.len() - 1][1] - stack[stack.len() - 2][1]) * (p[0] - stack[stack.len() - 1][0]) {
                stack.pop();
            }
            stack.push(p);
        }
        stack.len() as i32
    }
}