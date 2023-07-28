class Solution {
public:
    vector<int> busiestServers(int k, vector<int>& arrival, vector<int>& load) {
        
        // We have k servers numbered from 0 to k-1
        // Each server has infinite computational capacity
        // Each server can handle only one request at a time
        // Requests are assigned to servers according to the algorithm
        // 1. The ith request arrives
        // 2. If all servers are busy, the request is dropped
        // 3. If the (i % k)th server is available, assign the request to that server
        // 4. Otherwise, assign the request to the next available server
        //    (wrapping around the list of servers and starting from 0 if necessary)
        //    For example, if the ith server is busy, try to assign the request to the (i+1)th server,
        //    then the (i+2)th server, and so on.
        // We need to find the busiest server(s)
        // A server is considered busiest if it handled the most number of requests successfully among all the servers.
        // Return a list containing the IDs of the busiest server(s). You may return the IDs in any order.
        // Example 1:
        // k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3]
        // Output: [1]
        // Explanation:
        // All of the servers start out available.
        // The first 3 requests are handled by the first 3 servers in order.
        // Request 3 comes in. Server 0 is busy, so it's assigned to the next available server, which is 1.
        // Request 4 comes in. It cannot be handled since all servers are busy, so it is dropped.
        // Servers 0 and 2 handled one request each, while server 1 handled two requests. Hence server 1 is the busiest server.
        // Example 2:
        // k = 3, arrival = [1,2,3,4], load = [1,2,1,2]
        // Output: [0]
        // Explanation:
        // The first 3 requests are handled by first 3 servers.
        // Request 3 comes in. It is handled by server 0 since the server is available.
        // Server 0 handled two requests, while servers 1 and 2 handled one request each. Hence server
    }
};