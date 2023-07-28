impl Solution {
    pub fn mem_leak(memory1: i32, memory2: i32) -> Vec<i32> {
        
        let mut mem1 = memory1;
        let mut mem2 = memory2;
        let mut time = 1;
        while mem1 >= time || mem2 >= time {
            if mem1 >= mem2 {
                mem1 -= time;
            } else {
                mem2 -= time;
            }
            time += 1;
        }
        vec![time, mem1, mem2]
    }
}